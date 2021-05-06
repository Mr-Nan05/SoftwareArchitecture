// @ts-nocheck
import { plugin } from './plugin';
import * as Plugin_0 from 'C:/Users/MrNan/Desktop/students-frontend/src/app.ts';
import * as Plugin_1 from 'C:/Users/MrNan/Desktop/students-frontend/src/.umi/plugin-dva/runtime.tsx';
import * as Plugin_2 from '../plugin-initial-state/runtime';
import * as Plugin_3 from '../plugin-model/runtime';

  plugin.register({
    apply: Plugin_0,
    path: 'C:/Users/MrNan/Desktop/students-frontend/src/app.ts',
  });
  plugin.register({
    apply: Plugin_1,
    path: 'C:/Users/MrNan/Desktop/students-frontend/src/.umi/plugin-dva/runtime.tsx',
  });
  plugin.register({
    apply: Plugin_2,
    path: '../plugin-initial-state/runtime',
  });
  plugin.register({
    apply: Plugin_3,
    path: '../plugin-model/runtime',
  });
