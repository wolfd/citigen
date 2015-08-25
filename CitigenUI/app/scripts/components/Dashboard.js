import React, {Component} from 'react';
import {Row, Col} from 'react-bootstrap';
import Viewport from './Viewport';

class Dashboard extends Component {
  render() {
    return (
      <Row>
        <Col md={8}>
          <Viewport />
        </Col>
        <Col md={4}>
          create new
          buttons
          buttons
          forms
        </Col>
      </Row>
    );
  }
}

export default Dashboard;
