import React, { Component } from 'react';
import CaregiverService from '../caregiver/CaregiverService';

class UpdateCaregiver extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            name:'',
            birth_date:'',
            gender:'',
            address:'',  
            username:'',
            password:'' 
        }

        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeBirthdateHandler = this.changeBirthdateHandler.bind(this);
        this.changeGenderHandler = this.changeGenderHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.updateCaregiverButton = this.updateCaregiverButton.bind(this);
        this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.cancelButton = this.cancelButton.bind(this);
    }

    componentDidMount(){
        CaregiverService.getCaregiverById(this.state.id).then( (res) => {
            let caregiver = res.data;
            this.setState({name: caregiver.name,
                        birth_date: caregiver.birth_date,
                        gender: caregiver.gender,
                        address: caregiver.address});
        });
    }

    changeNameHandler = (event) => {
        this.setState({name: event.target.value});
    }

    changeBirthdateHandler = (event) => {
        this.setState({birth_date: event.target.value});
    }

    changeGenderHandler = (event) => {
        this.setState({gender: event.target.value});
    }

    changeAddressHandler = (event) => {
        this.setState({address: event.target.value});
    }

    changeUsernameHandler = (event) => {
        this.setState({username: event.target.value});
    }

    changePasswordHandler = (event) => {
        this.setState({password: event.target.value});
    }

    cancelButton(){
        this.props.history.push('/doctor');
    }

    updateCaregiverButton = (x) => {
        x.preventDefault();
        let caregiver = {name: this.state.name, birth_date: this.state.birth_date, gender: this.state.gender, address: this.state.address, username: this.state.username, password: this.state.password};
        console.log('caregiver => ' +JSON.stringify(caregiver));

        CaregiverService.updateCaregiver(caregiver, this.state.id).then(res => {
            this.props.history.push('/doctor');
        });
    }
    
    render() {
        return (
            <div>
                <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3"> 
                                <h1 className="text-center">Update Caregiver</h1>
                                <div className = "card-body">
                                    <form>
                                        <div className ="form-group">
                                            <label>Name: </label>
                                            <input placeholder="Name" name ="name" className="form-control"
                                                value={this.state.name} onChange={this.changeNameHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Birth-date: </label>
                                            <input placeholder="YYYY-MM-DD" name ="birthdate" className="form-control"
                                                value={this.state.birth_date} onChange={this.changeBirthdateHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Gender: </label>
                                            <input placeholder="M/F" name ="gender" className="form-control"
                                                value={this.state.gender} onChange={this.changeGenderHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Address: </label>
                                            <input placeholder="Address" name ="address" className="form-control"
                                                value={this.state.address} onChange={this.changeAddressHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Username: </label>
                                            <input placeholder="Username" name ="username" className="form-control"
                                                value={this.state.username} onChange={this.changeUsernameHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Password: </label>
                                            <input placeholder="Password" name ="password" className="form-control"
                                                value={this.state.password} onChange={this.changePasswordHandler}/>
                                        </div>
                                
                                        <button className="btn btn-success" onClick={this.updateCaregiverButton}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancelButton} style={{marginLeft: "10px"}}>Cancel</button>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
            </div>
        );
    }
}

export default UpdateCaregiver;