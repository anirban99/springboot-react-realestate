import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';
import {Bar} from 'react-chartjs-2';

class GroupList extends Component {

  constructor(props) {
    super(props);
    this.state = {groups: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('/api/v1/realestates')
      .then(response => response.json())
      .then(data => this.setState({groups: data, isLoading: false}));
  }

  // async componentDidMount() {
  //   const response = await fetch('/api/v1/realestates');
  //   const body = await response.json();
  //   this.setState({ groups: body, isLoading: false });
  // }.  width="20%"    commercializationType


  render() {

    const {groups, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const name = groups.map(group=>{ return group.name});

    const groupList = groups.map(group => {
      return <tr key={group.id}>
        <td style={{whiteSpace: 'nowrap'}}>{group.resultListEntries.addressToDisplay}</td>
        <td>{group.resultListEntries.commercializationType}</td>
        <td>{group.resultListEntries.features}</td>
        <td>{group.resultListEntries.floorSpace}</td>
        <td>{group.resultListEntries.docId}</td>
        <td>{group.resultListEntries.priceForTotalArea}</td>
        <td>{group.resultListEntries.realtorCompanyName}</td>
        <td>{group.resultListEntries.realtorName}</td>
        <td>{group.resultListEntries.title}</td>
        <td>{group.resultListEntries.pictureUrl}</td>
        <td>{group.resultListEntries.productType}</td>
      </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <h3>Real Estate List</h3>
          <h1>Berlin</h1>
          <Table className="mt-4">
            <thead>
            <tr>
              <th>Address Display</th>
              <th>Commercialization Type</th>
              <th>Features</th>
              <th>Floor Space</th>
              <th>Id</th>
              <th>Price For Total Area</th>
              <th>Realtor Company Name</th>
              <th>Realtor Name</th>
              <th>Title</th>
              <th>Picture Url</th>
              <th>Product Type</th>
            </tr>
            </thead>
            <tbody>
            {groupList}
            </tbody>
          </Table>
        </Container>
      </div>
    );
  }
}

export default GroupList;