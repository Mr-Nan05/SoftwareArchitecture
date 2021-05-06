// @ts-nocheck
import React from 'react';
import { ApplyPluginsType } from 'C:/Users/MrNan/Desktop/students-frontend/node_modules/umi/node_modules/@umijs/runtime';
import * as umiExports from './umiExports';
import { plugin } from './plugin';

export function getRoutes() {
  const routes = [
  {
    "path": "/",
    "component": require('@/layouts/index.jsx').default,
    "routes": [
      {
        "path": "/",
        "exact": true,
        "component": require('@/pages/index.jsx').default
      },
      {
        "path": "/student",
        "exact": true,
        "component": require('@/pages/student/index.jsx').default
      },
      {
        "path": "/student/:id",
        "exact": true,
        "component": require('@/pages/student/[id].jsx').default
      }
    ]
  }
];

  // allow user to extend routes
  plugin.applyPlugins({
    key: 'patchRoutes',
    type: ApplyPluginsType.event,
    args: { routes },
  });

  return routes;
}
