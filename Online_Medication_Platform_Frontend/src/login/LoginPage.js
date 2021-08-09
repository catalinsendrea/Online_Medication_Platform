import React, { Component } from 'react';
import PatientService from '../patient/PatientService';
import CaregiverService from '../caregiver/CaregiverService';
import DoctorService from '../doctor/DoctorService';
import InputFieldLoginComponent from './InputFieldLoginComponent';
import SubmitButtonLoginComponent from './SubmitButtonLoginComponent';

class LoginPage extends Component {
    constructor(props){
        super(props)

        this.state = {
            doctors: [],
            caregivers: [],
            patients:[],
            username: '',
            password: '',
            buttonDisabled: false    
        }
    }

    componentDidMount(){
        PatientService.getPatients().then((res) => {
            this.setState({ patients: res.data})
        });

        CaregiverService.getCaregivers().then((res) => {
            this.setState({ caregivers: res.data})
        });

        DoctorService.getDoctors().then((res) =>{
            this.setState({ doctors: res.data})
        });

    }

    setInputValue(property, val){
        val = val.trim();
        if(val.length > 15){
            return;
        }
        
        this.setState({
            [property]:val 
        })
    }

    resetForm(){
        this.setState({
            username: '',
            password:'',
            buttonDisabled: false
        })
    }

    doLogin(){

        if(!this.state.username){
            return;
        }

        if(!this.state.password){
            return;
        }

        this.setState({
            buttonDisabled: true
        })

        let ok1 = 0;
        let ok2 = 0;
        let ok3 = 0;

        for(let i = 0; i < this.state.doctors.length; i++){
            if(this.state.doctors[i].username === this.state.username && this.state.doctors[i].password === this.state.password){
                ok1 = 1;
            }
        }

        for(let i = 0; i < this.state.caregivers.length; i++){
            if(this.state.caregivers[i].username === this.state.username && this.state.caregivers[i].password === this.state.password){
                ok2 = 1;
                localStorage.setItem('patientID', this.state.caregivers[i].id);
            }
        }

        for(let i = 0; i < this.state.patients.length; i++){
            if(this.state.patients[i].username === this.state.username && this.state.patients[i].password === this.state.password){
                ok3 = 1;
            }
        }

        if(ok1 === 1 && ok2 === 0 && ok3 === 0){
            this.props.history.push('/doctor');
        }
        else if(ok1 === 0 && ok2 === 1 && ok3 === 0){
            this.props.history.push('/caregiver');
        }
        else if(ok1 === 0 && ok2 === 0 && ok3 === 1){
            this.props.history.push('/patient');
        }
        else{
            this.resetForm();
            alert("ERROR: You have entered incorrect username or password.");
        }

    }
    
    render() {
        return (
            <div className = "app">
                <div className = "loginForm">
                    <div className ="containerLogin">
                        Log in
                        <InputFieldLoginComponent
                            type ='text'
                            placeholder = 'Username'
                            value = {this.state.username ? this.state.username : ''}
                            onChange = { (val) => this.setInputValue('username', val) }
                        />

                        <InputFieldLoginComponent
                            type ='password'
                            placeholder = 'Password'
                            value = {this.state.password ? this.state.password : ''}
                            onChange = { (val) => this.setInputValue('password', val) }
                        />

                        <SubmitButtonLoginComponent
                            text = 'Login'
                            disabled = {this.state.buttonDisabled}
                            onClick = { () => this.doLogin() }
                        />
                    </div>
                </div>
            </div>
        );
    }
}

export default LoginPage;