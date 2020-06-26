import React, { Component } from 'react';
import CurrenciesContext from '../CurrenciesContext';

class ListCurrenciesComponent extends Component{
    static contextType = CurrenciesContext;

    render() {
        return (
            <div className="container">
                <h3>All Currencies</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Code</th>
                                <th>Name</th>
                                <th>Rate</th>
                                <th>Ratio</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.context.map(
                                    currency =>
                                    <tr key={currency.code}>                                    
                                        <td>{currency.code}</td>
                                        <td>{currency.name}</td>
                                        <td>{currency.rate}</td>
                                        <td>{currency.ratio}</td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListCurrenciesComponent;