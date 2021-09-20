import * as React from 'react';



export default function AccountList({ transactions }) {
	return (
		<div>
			<h1>Transactions</h1>
			<table>
				<thead>
					<tr>
						<td>Id</td><td>Account ID</td><td>Amount</td>
					</tr>
				</thead>
				<tbody>
					{transactions.map((row) => (
						<tr>
							<td>{row.id}</td>
							<td>{row.account.id}</td>
							<td>{row.amount}</td>
						</tr>
					))}
				</tbody>
			</table>
		</div>
	);
}