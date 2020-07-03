import React, { Component } from 'react';
import { Formik, Form, Field } from 'formik';
import CurrencyDataService from '../service/CurrencyDataService';


class AddComponent extends Component {
    constructor(props) {
        super(props)

        this.onSubmit = this.onSubmit.bind(this)
    }

    onSubmit(values) {
        console.log(values.code)
        console.log(values.name)
        console.log(values.rate)
        console.log(values.ratio)
        CurrencyDataService.addCurrency(values.code, values.name, values.rate, values.ratio)
            .then(
                response => {
                    console.log(response.data)
                    // to check status code
                    //radirect to "/"
                    this.props.history.push('/');
                }
            )
    }


    render(){
        return(
            <div className="container">
            <Formik initialValues={{ code: "", name: "", rate: 0.0, ratio:1 }}
                onSubmit={this.onSubmit}>
                <Form>
                    <div className="form-group">
                        <label htmlFor="codeFrom">Code:</label>
                        <Field type="text" className="form-control" name="code" id="code">                        
                            
                        </Field>
                    </div>
                    <div className="form-group">
                        <label htmlFor="codeTo">To:</label>
                        <Field type="text" className="form-control selectpicker" name="name" id="name">
                       
                           
                        </Field>
                    </div>
                    <div className="form-group">
                        <label htmlFor="rate">Rate:</label>
                        <Field type="number" className="form-control" name="rate" id="rate"></Field>
                    </div>
                    <div className="form-group">
                        <label htmlFor="ratio">Ratio:</label>
                        <Field type="number" className="form-control" name="ratio" id="ratio"></Field>
                    </div>
                    <button className="btn btn-success" type="submit">Add</button>
                </Form>
            </Formik>
            </div >
        )
    }
}

export default AddComponent;
