import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import GroupList from './GroupList';

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


// ----------------------------1st edit

// import React, { Component } from 'react';
// import logo from './logo.svg';
// import './App.css';

// class App extends Component {
// state = {
//     isLoading: true,
//     groups: []
//   };

//   async componentDidMount() {
//     const response = await fetch('/api/v1/realestates');
//     const body = await response.json();
//     this.setState({ groups: body, isLoading: false });
//   }

//   render() {
//     const {groups, isLoading} = this.state;

//     if (isLoading) {
//       return <p>Loading...</p>;
//     }
//     return (
//       <div className="App">
//         <header className="App-header">
//           <img src={logo} className="App-logo" alt="logo" />
//           <div className="App-intro">
//             <h2>JUG List</h2>
//             {groups.map(group =>
//               <div key={group.id}>
//                 {group.addressToDisplay}
//               </div>
//             )}
//           </div>
//         </header>
//       </div>
//     );
//   }
// }


// --------------------------------------- default

// 
//   render() {
//     return (
//       <div className="App">
//         <header className="App-header">
//           <img src={logo} className="App-logo" alt="logo" />
//           <p>
//             Edit <code>src/App.js</code> and save to reload.
//           </p>
//           <a
//             className="App-link"
//             href="https://reactjs.org"
//             target="_blank"
//             rel="noopener noreferrer"
//           >
//             Learn React
//           </a>
//         </header>
//       </div>
//     );
//   }
// }
