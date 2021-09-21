import React, { useState, useEffect } from 'react';



export default function AccountList({ customer, accounts, onAccountSelected }) {

	const [accs, setAccs] = useState([]);
	useEffect(() => {
		setAccs(accounts);
	}, []);

	const addAccount = (account) => {
		console.log('Adding account : ' + account)
		fetch('/accounts', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
				'Accept': 'application/json'
			},
			body: JSON.stringify(account)
		}).then(function(response) {
			console.log(response);
			return response.json();
		}).then(function(json) {
			setAccs([...accs, json]);
		})
	}

	return (
		<div>
			<h1>Account</h1>
			<div>
				<form onSubmit={() => addAccount({ customerId: customer.id, amount: 0.01 })}>
					<table>
						<tbody>
							<tr>
								<td>Inital credit</td>
								<td><input type="text" /></td>
								<td><button>Add</button></td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
			<div>
				<table>
					<thead>
						<tr>
							<td>Id</td><td>Customer</td><td>Initial Credit</td><td>Balance</td>
						</tr>
					</thead>
					<tbody>
						{accs.map((row) => (
							<tr key={row.id} onClick={() => onAccountSelected(row)}>
								<td>{row.id}</td>
								<td>{row.customer.firstname} {row.customer.lastname}</td>
								<td>{row.initialCredit}</td>
								<td>{row.balance}</td>
							</tr>
						))}
					</tbody>
				</table>
			</div>
		</div>
	);
}