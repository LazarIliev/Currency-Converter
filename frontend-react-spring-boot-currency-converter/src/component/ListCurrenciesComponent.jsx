import React, { Component } from 'react';
import CurrenciesContext from '../CurrenciesContext';
import AuthenticationService from '../service/AuthenticationService';
import CurrencyDataService from '../service/CurrencyDataService'
import { Table, Button, Alert } from 'react-bootstrap';



class ListCurrenciesComponent extends Component{
    static contextType = CurrenciesContext;

    constructor(props) {
        super(props);

        this.deleteCurrency = this.deleteCurrency.bind(this);
    }

    deleteCurrency(code){
        CurrencyDataService.deleteCurrency(code)
        .then(res => {
            console.log(res);
            //this.props.history.push('/') // this.props.history.push('/');
        })
    }

    render() {
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
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
                                {isUserLoggedIn && <th>Delete</th>}
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
                                        {isUserLoggedIn && <td><Button variant="danger" onClick={() => this.deleteCurrency(currency.code)} >Delete</Button></td>}
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