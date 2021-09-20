import React, { useState, useEffect } from 'react';
import CustomerList from './CustomerList';
import AccountList from './AccountList';
import TransactionList from './TransactionList';


export default function Home() {
	const [customers, setCustomers] = useState([]);
	const [accounts, setAccounts] = useState([]);
	const [transactions, setTransactions] = useState([]);
	const [selectedCustomer, setSelectedCustomer] = useState({});
	const [selectedAccount, setSelectedAccount] = useState({});

	const onCustomerSelected = (customer) => {
		console.log('Customer selected ...')
		setSelectedCustomer(customer);
		fetch('/accounts?customerId=' + customer.id, {
			headers: {
				'Content-Type': 'application/json',
				'Accept': 'application/json'
			}
		}).then(function(response) {
			console.log(response);
			return response.json();
		}).then(function(json) {
			setAccounts(json);
			setTransactions([]);
		})
	}

	const onAccountSelected = (account) => {
		console.log('Account selected ...' + account.id);
		setSelectedAccount(account);
		fetch('/accounts/' + account.id + '/transactions', {
			headers: {
				'Content-Type': 'application/json',
				'Accept': 'application/json'
			}
		}).then(function(response) {
			console.log(response);
			return response.json();
		}).then(function(json) {
			setTransactions(json);
		})
	}

	const getCustomers = () => {
		fetch('/customers', {
			headers: {
				'Content-Type': 'application/json',
				'Accept': 'application/json'
			}
		}).then(function(response) {
			console.log(response);
			return response.json();
		}).then(function(json) {
			setCustomers(json);
			setAccounts([]);
			setTransactions([]);
		})
	}

	useEffect(() => {
		getCustomers();
	}, []);
	return (
		<div>
			<CustomerList customers={customers} onCustomerSelected={onCustomerSelected} />
			<AccountList accounts={accounts} onAccountSelected={onAccountSelected} customer = {selectedCustomer}/>
			<TransactionList transactions={transactions} selectedAccount={selectedAccount} />
		</div>
	);
}