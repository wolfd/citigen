import React from 'react';
import Router from 'react-router';
import routes from './routes';

window.addEventListener('DOMContentLoaded', () => {
  Router.run(
    routes,
    Router.HistoryLocation,
    Handler => React.render(
      <Handler />,
      document.getElementById('page')
    )
  );
});
