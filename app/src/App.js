import React, { Component } from 'react';
import './App.css';
import Home from './components/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GroupList from './components/GroupList';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/realestates' exact={true} component={GroupList}/>
        </Switch>
      </Router>
    )
  }
}

export default App;
