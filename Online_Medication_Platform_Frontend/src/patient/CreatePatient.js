import React, { Component } from 'react';
import PatientService from '../patient/PatientService';

class CreatePatient extends Component {
    constructor(props){
        super(props)

        this.state = {
            id:'',
            name:'',
            birth_date:'',
            gender:'',
            address:'', 
            medical_record:'',
            caregiver_id:'',
            username:'',
            password:''  
        }

        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeBirthdateHandler = this.changeBirthdateHandler.bind(this);
        this.changeGenderHandler = this.changeGenderHandler.bind(this);
        this.changeAddressHandler = this.changeAddressHandler.bind(this);
        this.changeMedicalRecordHandler = this.changeMedicalRecordHandler.bind(this);
        this.changeCaregiverIdHandler = this.changeCaregiverIdHandler.bind(this);
        this.changeUsernameHandler = this.changeUsernameHandler.bind(this);
        this.changePasswordHandler = this.changePasswordHandler.bind(this);
        this.savePatientButton = this.savePatientButton.bind(this);
        this.cancelButton = this.cancelButton.bind(this);
    }

    changeIdHandler = (event) => {
        this.setState({id: event.target.value});
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

    changeMedicalRecordHandler = (event) => {
        this.setState({medical_record: event.target.value});
    }

    changeCaregiverIdHandler = (event) => {
        this.setState({caregiver_id: event.target.value});
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

    savePatientButton = (x) => {
        x.preventDefault();
        let patient = {id: this.state.id, name: this.state.name, birth_date: this.state.birth_date, gender: this.state.gender, address: this.state.address, medical_record: this.state.medical_record, caregiver_id: this.state.caregiver_id, username: this.state.username, password: this.state.password};
        console.log('patient => ' +JSON.stringify(patient));

        PatientService.createPatient(patient).then(res => {
            this.props.history.push('/doctor');
        });
    }
    
    
    render() {
        return (
            <div>
                <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3"> 
                                <h1 className="text-center">Insert Patient</h1>
                                <div className = "card-body">
                                    <form>
                                        <div className ="form-group">
                                            <label>Id: </label>
                                            <input placeholder="Id" name ="id" className="form-control"
                                                value={this.state.id} onChange={this.changeIdHandler}/>
                                        </div>

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
                                            <label>Medical record: </label>
                                            <input placeholder="Medical record" name ="medical_record" className="form-control"
                                                value={this.state.medical_record} onChange={this.changeMedicalRecordHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Caregiver id: </label>
                                            <input placeholder="(Integer)" name ="Caregiver_id" className="form-control"
                                                value={this.state.caregiver_id} onChange={this.changeCaregiverIdHandler}/>
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
                                
                                        <button className="btn btn-success" onClick={this.savePatientButton}>Save</button>
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

export default CreatePatient;