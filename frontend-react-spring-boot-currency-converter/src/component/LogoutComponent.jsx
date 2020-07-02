import React, { Component } from 'react'
import AuthenticationService from '../service/AuthenticationService';


class LogoutComponent extends Component {
    componentDidMount(){
        AuthenticationService.logout();
    }

    render() {
        return (
            <>
                <h1>You are logged out</h1>
                <div className="container">
                    Thank You for Using Our Application.
                </div>
            </>
        )
    }
}
export default LogoutComponent