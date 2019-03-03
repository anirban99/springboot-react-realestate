import React, { Component } from 'react';
import '../App.css';
import AppNavbar from './AppNavbar';
import dataJson from '../data.json';
import { Link } from 'react-router-dom';
import { Button, ButtonGroup, Container, Table} from 'reactstrap';
import {
    XYPlot,
    XAxis, // Shows the values on x axis
    YAxis, // Shows the values on y axis
    VerticalBarSeries,
    LabelSeries
} from 'react-vis';

class MyBarChart extends Component {

  constructor(props) {
    super(props);
    this.state = {groups: [], isLoading: true};
  }

  componentDidMount() {
    this.setState({isLoading: true});

    fetch('/api/v1/realestates/count')
      .then(response => response.json())
      .then(data => this.setState({groups: data, isLoading: false}));
  }

    render() {
        // const data = this.props.data;
        const {groups} = this.state;
        const data = {groups};
        const chartWidth = 800;
        const chartHeight = 10;
        const chartDomain = [0, chartHeight];
        return (
            <div>
              <AppNavbar/>
                <Container fluid>
                  <h3>Real Estate Bar Chart</h3>
                    <XYPlot 
                      xType="ordinal" 
                      width={chartWidth} 
                      height={chartHeight} 
                      yDomain={chartDomain}
                    >
                    <XAxis />
                    <YAxis />
                    <VerticalBarSeries
                      data={data}
                    />
                    <LabelSeries
                      data={data.map(obj => {
                        return { ...obj, label: obj.total.toString() }
                      })}
                      labelAnchorX="middle"
                      labelAnchorY="text-after-edge"
                    />
                    </XYPlot>
                </Container>
            </div>
        );
    }
}
export default MyBarChart;