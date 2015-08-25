import React from 'react';
import { Route, DefaultRoute, NotFoundRoute } from 'react-router';
import App from './components/App';
import Dashboard from './components/Dashboard';

export default (
  <Route name="App" path="/" handler={App}>
    <DefaultRoute name="app" handler={Dashboard} />
  </Route>
);
