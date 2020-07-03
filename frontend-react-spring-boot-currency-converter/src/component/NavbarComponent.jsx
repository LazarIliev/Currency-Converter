import React, { Component } from 'react';
import AuthenticationService from '../service/AuthenticationService';
import { Link, withRouter } from 'react-router-dom';


class NavbarComponent extends Component {
    render(){
        const isUserLoggedIn = AuthenticationService.isUserLoggedIn();
        return(
            <nav className="navbar navbar-dark bg-dark mb-3">
                  {!isUserLoggedIn && <li><Link className="nav-link" to="/login">Login</Link></li>}
                 {/*   admin name */}
                {isUserLoggedIn && <li><label>{AuthenticationService.getLoggedInUserName()}</label></li>}
                {isUserLoggedIn && <li><Link className="nav-link" to="/add">Add Currency</Link></li>}
                 {isUserLoggedIn && <li><Link className="nav-link" to="/logout">Logout</Link></li>}
            </nav>
        );
    }
}

export default NavbarComponent;