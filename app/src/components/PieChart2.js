// import React, {Component} from 'react';
// import Chartjs from 'chart.js'
// var LineChart = require("react-chartjs").Line;

// class PieChart extends Component {
//     constructor() {
//         super();
//     }

//     render() {
//        var chartOptions: {


//      // Boolean - If we should show the scale at all


//     showScale: true,
//     // Boolean - Whether to show a dot for each point
//     pointDot: true,
//     showLines: false,
//     title: {
//         display: true,
//         text: 'Chart.js Line Chart'
//     },
//     legend: {
//         display: true,
//         labels: {
//            boxWidth: 50,
//            fontSize: 10,
//            fontColor: '#bbb',
//            padding: 5,

//         }
//     }
//     }

//     var chartData= {
//         labels: ['1', '2', '3', '4'],
//         datasets: [
//             {
//                 label: 'Current lag',
//                 fill: false,
//                 lineTension: 0.1,
//                 backgroundColor: "rgba(75,192,192,0.4)",
//                 borderColor: "rgba(75,192,192,1)",
//                 borderCapStyle: 'butt',
//                 borderDashOffset: 0.0,
//                 borderJoinStyle: 'miter',
//                 data: [50, 35, 60, 67]
//             }
//         ]
//     }


//         return (
//             <div className="">
//                 <LineChart data={chartData} options={chartOptions} width="600" height="250"/>
//             </div>
//         );
//     }
// }

// 


// import React, { Component } from 'react';
// import {Pie} from 'react-chartjs-2';

// const data = {
//    labels: [
//     'Red',
//     'Green',
//     'Yellow'
//    ],
//    datasets: [{
//       data: [300, 50, 100],
//       backgroundColor: [
//         '#FF6384',
//         '#36A2EB',
//         '#FFCE56'
//    ],
//    hoverBackgroundColor: [
//      '#FF6384',
//      '#36A2EB',
//      '#FFCE56'
//    ]
//  }]
// };

// class PieChart extends Component {

//   render() {
//      return (
//        <div>
//          <h2>PieChart</h2>
//          <Pie height="100px" data={data} />
//        </div>
//      );
//   }

// }

// export default PieChart;
