import React, { Component } from 'react';
import ListCurrenciesComponent from './ListCurrenciesComponent';

class InstructorApp extends Component {
    render() {
        return (<>
            <h1> Instructor Application!</h1>
            <ListCurrenciesComponent/>
            </>
        )
    }
}

export default InstructorApp