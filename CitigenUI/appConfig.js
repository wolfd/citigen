const appConfig = {
  appRoot: process.env.CITIGEN_APP_URI || '/citigen/ui',
  // If we have an env variable, gulp is proxying it through /api.
  // Otherwise we'll get it from localStorage later.
  apiRoot: process.env.CITIGEN_API_URL ? '/api' : ''
};

module.export = appConfig;
