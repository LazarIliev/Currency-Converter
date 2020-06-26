import React, { Component } from 'react';
import ListCurrenciesComponent from './ListCurrenciesComponent';

class IndexAppComponent extends Component {
    render() {
        return(
            <div className="container">
                <ListCurrenciesComponent/>
            </div>
        );
    }
}

export default IndexAppComponent;