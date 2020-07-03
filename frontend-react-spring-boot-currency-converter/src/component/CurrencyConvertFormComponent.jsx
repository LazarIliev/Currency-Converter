import React, { Component } from 'react';
import { Formik, Form, Field } from 'formik';
import CurrenciesContext from '../CurrenciesContext';
import CurrencyDataService from '../service/CurrencyDataService';


class CurrencyConvertFormComponent extends Component {
    static contextType = CurrenciesContext;

    constructor(props) {
        super(props)
        this.state = {
            result: 0
        }

        this.onSubmit = this.onSubmit.bind(this)
    }

    onSubmit(values) {
        console.log(values.codeFrom)
        console.log(values.codeTo)
        console.log(values.amount)
        CurrencyDataService.convertCurrency(values.codeFrom, values.codeTo, values.amount)
            .then(
                response => {
                    console.log(response.data)
                    this.setState({ result: response.data })
                }
            )
    }

    render() {
        return (
            <div className="container">
                <Formik initialValues={{ codeFrom: "", codeTo: "", amount: 0.0 }}
                    onSubmit={this.onSubmit}>
                    <Form>
                        <div className="form-group">
                            <label htmlFor="codeFrom">From:</label>
                            <Field as="select" type="text" className="form-control selectpicker" name="codeFrom" id="codeFrom">
                                <option value="">Select currency code from</option>
                                {
                                    this.context.map(currency =>
                                        <option key={currency.code} value={currency.code} >{currency.code}</option>
                                    )
                                }
                            </Field>
                        </div>
                        <div className="form-group">
                            <label htmlFor="codeTo">To:</label>
                            <Field as="select" className="form-control selectpicker" name="codeTo" id="codeTo">
                                <option value="">Select currency code to</option>
                                {
                                    this.context.map(currency =>
                                        <option key={currency.code} value={currency.code} text={currency.code} >{currency.code}</option>
                                    )
                                }
                            </Field>
                        </div>
                        <div className="form-group">
                            <label htmlFor="amount">Amount:</label>
                            <Field type="number" className="form-control" name="amount" id="amount"></Field>
                        </div>
                        <button className="btn btn-success" type="submit">Convert</button>
                    </Form>
                </Formik>
                <div className="form-group">
                    <label>Result:</label>
                    <label>{this.state.result}</label>
                </div>
            </div >
        )
    }
}

export default CurrencyConvertFormComponent;