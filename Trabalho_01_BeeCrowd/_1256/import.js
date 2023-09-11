import React from 'react';
import * as ast from '@readme/markdown';
import rdmd from '@readme/markdown';

export default ({ body }) => (
  <div className="markdown-body">
    {rdmd(body)}
  </div>
);
