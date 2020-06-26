import React, { Component } from 'react';
import ListCurrenciesComponent from './ListCurrenciesComponent';
import CurrencyDataService from '../service/CurrencyDataService';
import CurrenciesContext from '../CurrenciesContext'

class IndexAppComponent extends Component {
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
                    this.setState( { currencies: response.data })
                }
            )
    }

    render() {
        return(
            <div className="container">
                <CurrenciesContext.Provider value={this.state.currencies}>
                    <ListCurrenciesComponent/>
                </CurrenciesContext.Provider>
            </div>
        );
    }
}

export default IndexAppComponent;