import React, { Component } from 'react';
import './App.css';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import IndexAppComponent from './component/IndexAppComponent';
import LoginComponent from './component/LoginComponent';
import LogoutComponent from './component/LogoutComponent';
import AuthenticatedRoute from './component/AuthenticatedRoute';
import AddComponent from './component/AddComponent';

class App extends Component {
  render() {
    return (
      <Router>
        {/* remove h1 */}
        {/* <h1> Currency Convertor Application!</h1> */}
        {/* to add menu component */}
        <Switch>
          {/* to use context for data  */}
          {/* to change path="/" component=IndexAppComponent onLoading to save data into the context */}
          <Route path="/" exact component={IndexAppComponent} />
          <Route path="/login" exact component={LoginComponent}/>
          <AuthenticatedRoute path="/logout" exact component={LogoutComponent} />
          <AuthenticatedRoute path="/add" exact component={AddComponent} />
          {/* //<Route path="/login" exact component={LoginComponent} /> */}
          {/* <AuthenticatedRoute path="/logout" exact component={LogoutComponent} /> */}
          {/* <AuthenticatedRoute path="/courses" exact component={ListCoursesComponent} /> */}
        </Switch>
      </Router>
    );
  }
}

export default App;
