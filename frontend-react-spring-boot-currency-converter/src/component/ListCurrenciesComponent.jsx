import React, { Component } from 'react';
import CurrencyDataService from '../service/CurrencyDataService';


class ListCurrenciesComponent extends Component{
    constructor(props) {
        super(props)
        this.state = {
            currencies: [],
            message: null
        }
        this.getCurrencies = this.getCurrencies.bind(this)
    }

    componentDidMount(){
        this.getCurrencies();
    }

    getCurrencies(){
        CurrencyDataService.retrieveAllCurrencies()
            .then(
                response => {
                    // console.log(response);
                    this.setState( { currencies: response.data })
                }
            )
    }

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
                                this.state.currencies.map(
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