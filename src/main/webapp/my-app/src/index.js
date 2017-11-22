import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import LoginForm from './LoginForm';
import registerServiceWorker from './registerServiceWorker';

function Hi() {
  return <h2>hi, {LoginForm.login}</h2>
}

ReactDOM.render(<LoginForm />, document.getElementById('root'));
ReactDOM.render(<Hi />, document.getElementById('hi'));
registerServiceWorker();
