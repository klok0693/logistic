import React, {PureComponent} from 'react';
import './LoginForm.css';

function Hi(props) {
      return <h2>Hi, {props.login}</h2>
  }

class LoginForm extends PureComponent {

  constructor(props) {
    super(props);
    this.state = {login:'', password:''};

    this.onSubmit      = this.onSubmit.bind(this);
    this.onSetPassword = this.onSetPassword.bind(this);
    this.onSetLogin    = this.onSetLogin.bind(this);
  }

  onSubmit() {
    function onClick(e) {
      alert('Hi, {this.state.login}');
      e.preventDefault;
    }

    return (<a onClick ={onClick}>show message </a>);
  }

  onSetPassword(props) {
    this.setState({password: props.password});
  }

  onSetLogin(props) {
    this.setState({login: props.login});
  }

  render(){
    return(
          <form onSubmit = {this.onSubmit}>
            <p>
              <label> login: <input type="text" name="login" value={this.state.login} onChange = {this.onSetLogin} />
              </label>
            </p>
            <p><input type="submit" value="log in" /></p>
          </form>
        );
  }
}

export default LoginForm;
