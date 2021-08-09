import React, { Component } from 'react';
import IntakeService from '../intake/IntakeService';

class CreateIntake extends Component {
    constructor(props) {
        super(props)
        this.state = {
            id:'',
            number:'',
            start_date: '',
            end_date: '',
            patient_id: '',
            medication_id: ''
        }

        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeNumberHandler = this.changeNumberHandler.bind(this);
        this.changeStartDateHandler = this.changeStartDateHandler.bind(this);
        this.changeEndDateHandler = this.changeEndDateHandler.bind(this);
        this.changePatientIdHandler = this.changePatientIdHandler.bind(this);
        this.changeMedicationIdHandler = this.changeMedicationIdHandler.bind(this);
        this.createIntakeButton = this.createIntakeButton.bind(this);
        this.cancelButton = this.cancelButton.bind(this);
       
    }

    changeIdHandler = (event) => {
        this.setState({id: event.target.value});
    }

    changeNumberHandler = (event) => {
        this.setState({number: event.target.value});
    }

    changeStartDateHandler = (event) => {
        this.setState({start_date: event.target.value});
    }

    changeEndDateHandler = (event) => {
        this.setState({end_date: event.target.value});
    }

    changePatientIdHandler = (event) => {
        this.setState({patient_id: event.target.value});
    }

    changeMedicationIdHandler = (event) => {
        this.setState({medication_id: event.target.value});
    }

    createIntakeButton = (x) => {
        x.preventDefault();
        let intake = {
            id: this.state.id,
            number: this.state.number,
            start_date: this.state.start_date,
            end_date: this.state.end_date,
            patient_id: this.state.patient_id,
            medication_id: this.state.medication_id
        }
        console.log('intake => ' +JSON.stringify(intake));

        IntakeService.createIntake(intake).then(res => {
            this.props.history.push('/doctor');
        });
    }

    cancelButton(){
        this.props.history.push('/doctor');
    }
    
    render() {
        return (
            <div>
                <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3"> 
                                <h1 className="text-center">Create a Medication plan</h1>
                                <div className = "card-body">
                                    <form>
                                        <div className ="form-group">
                                            <label>Id: </label>
                                            <input placeholder="Id" name ="id" className="form-control"
                                                value={this.state.id} onChange={this.changeIdHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Number to take per day: </label>
                                            <input placeholder="(Integer)" name ="number" className="form-control"
                                                value={this.state.number} onChange={this.changeNumberHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Start-date: </label>
                                            <input placeholder="YYYY-MM-DD" name ="startdate" className="form-control"
                                                value={this.state.start_date} onChange={this.changeStartDateHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>End-date: </label>
                                            <input placeholder="YYYY-MM-DD" name ="enddate" className="form-control"
                                                value={this.state.end_date} onChange={this.changeEndDateHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Patient ID: </label>
                                            <input placeholder="(Integer)" name ="patient_id" className="form-control"
                                                value={this.state.patient_id} onChange={this.changePatientIdHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Medication ID: </label>
                                            <input placeholder="(Integer)" name ="medication_id" className="form-control"
                                                value={this.state.medication_id} onChange={this.changeMedicationIdHandler}/>
                                        </div>
                                
                                        <button className="btn btn-success" onClick={this.createIntakeButton}>Save</button>
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

export default CreateIntake;