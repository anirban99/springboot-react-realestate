import React, { Component } from 'react';
import { Button, ButtonGroup, Container, Table } from 'reactstrap';
import AppNavbar from './AppNavbar';
import { Link } from 'react-router-dom';

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
  // }.  width="20%"

  render() {
    const {groups, isLoading} = this.state;

    if (isLoading) {
      return <p>Loading...</p>;
    }

    const groupList = groups.map(group => {
      const address = `${group.address || ''} ${group.city || ''} ${group.stateOrProvince || ''}`;
      return <tr key={group.id}>
        <td style={{whiteSpace: 'nowrap'}}>{group.addressToDisplay}</td>
        <td>{group.commercializationType}</td>
        <td>{group.features}</td>
        <td>{group.floorSpace}</td>
        <td>{group.id}</td>
        <td>{group.priceForTotalArea}</td>
        <td>{group.realtorCompanyName}</td>
        <td>{group.realtorName}</td>
        <td>{group.title}</td>
        <td>{group.pictureUrl}</td>
        <td>{group.productType}</td>
      </tr>
    });

    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <h3>Real Estate List</h3>
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