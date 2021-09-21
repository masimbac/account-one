import * as React from 'react';



export default function CustomerList({ customers, onCustomerSelected }) {
	return (
		<div>
			<h1>Customers</h1>
			<table>
				<thead>
					<tr>
						<td>Id</td><td>First Name</td><td>Last Name</td>
					</tr>
				</thead>
				<tbody>
					{customers.map((row) => (
						<tr key={row.id} onClick={() => onCustomerSelected(row)}>
							<td>{row.id}</td>
							<td>{row.firstname}</td>
							<td>{row.lastname}</td>
						</tr>
					))}
				</tbody>
			</table>
		</div>
	);
}