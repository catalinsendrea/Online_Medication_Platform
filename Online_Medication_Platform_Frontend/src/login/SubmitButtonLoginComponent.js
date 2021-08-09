import React, { Component } from 'react';

class SubmitButtonLoginComponent extends Component {
    render() {
        return (
            <div className= "submitButton">
                <button  className= 'btnLogin' disabled={this.props.disabled}  onClick ={ () => this.props.onClick() } >{this.props.text}</button>
            </div>
        );
    }
}

export default SubmitButtonLoginComponent;