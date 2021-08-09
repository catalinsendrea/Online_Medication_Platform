import React, { Component } from 'react';
import PatientService from '../patient/PatientService';
import CaregiverService from '../caregiver/CaregiverService';
import MedicationService from '../medication/MedicationService';

class DoctorPageComponent extends Component {

    constructor(props){
        super(props)

        this.state = {
                patients: [],
                caregivers: [],
                medications: []
        }

        this.deleteCaregiver = this.deleteCaregiver.bind(this);
        this.deletePatient = this.deletePatient.bind(this);
        this.deleteMedication = this.deleteMedication.bind(this);

        this.addCaregiver = this.addCaregiver.bind(this);
        this.addMedication = this.addMedication.bind(this);
        this.addPatient = this.addPatient.bind(this);

        this.updateCaregiver = this.updateCaregiver.bind(this);
        this.updateMedication = this.updateMedication.bind(this);
        this.updatePatient = this.updatePatient.bind(this);

        this.addMedicationPlan = this.addMedicationPlan.bind(this);

    }

    componentDidMount(){
        PatientService.getPatients().then((res) => {
            this.setState({ patients: res.data})
        });

        CaregiverService.getCaregivers().then((res) => {
            this.setState({ caregivers: res.data})
        });

        MedicationService.getMedications().then((res) =>{
            this.setState({ medications: res.data})
        });

    }

    addCaregiver(){
        this.props.history.push('/add-caregiver'); 
    }

    addMedication(){
        this.props.history.push('/add-medication');
    }

    addPatient(){
        this.props.history.push('/add-patient');
    }

    deleteCaregiver(id){
        CaregiverService.deleteCaregiver(id).then( res => {
            this.setState({caregivers: this.state.caregivers.filter(caregiver => caregiver.id !== id)
            });
        });
    }

    deletePatient(id){
        PatientService.deletePatient(id).then( res => {
            this.setState({patients: this.state.patients.filter(patient => patient.id !== id)
            });
        });
    }

    deleteMedication(id){
        MedicationService.deleteMedication(id).then( res => {
            this.setState({medications: this.state.medications.filter(medication => medication.id !== id)
            });
        });
    }

    updateCaregiver(id){
        this.props.history.push(`/update-caregiver/${id}`); 
    }

    updateMedication(id){
        this.props.history.push(`/update-medication/${id}`); 
    }

    updatePatient(id){
        this.props.history.push(`/update-patient/${id}`); 
    }

    addMedicationPlan(){
        this.props.history.push('/add-intake');
    }

    render() {
        return (
            <div>

                <h3 className="text-center">Caregiver list</h3>

                <div className= "row">
                <button className= "btn btn-success pull-right" onClick={this.addMedicationPlan} style={{marginLeft: "935px"}} > Create a medication plan </button>
                </div>

                <div className= "row">
                    <button className= "btn btn-primary" onClick={this.addCaregiver}> Add Caregiver </button>
                </div>


                <div className = "row">
                    <table className = "table table-striped table-bordered">
                        
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Birth-date</th>
                                <th>Gender</th>
                                <th>Address</th>
                                <th>Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                        {
                                this.state.caregivers.map(
                                    caregiver => 
                                    <tr key = {caregiver.id}>
                                        <td>{caregiver.id}</td>
                                        <td>{caregiver.name}</td>
                                        <td>{caregiver.birth_date}</td>
                                        <td>{caregiver.gender}</td>
                                        <td>{caregiver.address}</td>
                                        <td>
                                            <button onClick = { () => this.updateCaregiver(caregiver.id)} className = " btn btn-info">Update</button>
                                            <button onClick = { () => this.deleteCaregiver(caregiver.id)} className = " btn btn-danger" style={{marginLeft: "15px"}}>Delete</button>
                                        </td>
                                    </tr>
                                )
                        }
                        </tbody>
                    </table>
                </div>


                <h3 className="text-center">Patient list</h3>
                
                <div className= "row">
                    <button className= "btn btn-primary" onClick={this.addPatient}> Add Patient </button>
                </div>

                <div className = "row">
                    <table className = "table table-striped table-bordered">
                        
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Birth-date</th>
                                <th>Gender</th>
                                <th>Address</th>
                                <th>Medical record</th>
                                <th>Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                        {
                                this.state.patients.map(
                                    patient => 
                                    <tr key = {patient.id}>
                                        <td>{patient.id}</td>
                                        <td>{patient.name}</td>
                                        <td>{patient.birth_date}</td>
                                        <td>{patient.gender}</td>
                                        <td>{patient.address}</td>
                                        <td>{patient.medical_record}</td>
                                        <td>
                                            <button onClick = { () => this.updatePatient(patient.id)} className = " btn btn-info">Update</button>
                                            <button onClick = { () => this.deletePatient(patient.id)} className = " btn btn-danger" style={{marginLeft: "15px"}}>Delete</button>
                                        </td>
                                    </tr>
                                )
                        }
                        </tbody>
                    </table>
                </div>


                <h3 className="text-center">Medication list</h3>
                
                <div className= "row">
                    <button className= "btn btn-primary" onClick={this.addMedication}> Add Medication </button>
                </div>

                <div className = "row">
                    <table className = "table table-striped table-bordered">
                        
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Name</th>
                                <th>Side effects</th>
                                <th>Dosage(mg)</th>
                                <th>Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                        {
                                this.state.medications.map(
                                    medication => 
                                    <tr key = {medication.id}>
                                        <td>{medication.id}</td>
                                        <td>{medication.name}</td>
                                        <td>{medication.list_of_side_effects}</td>
                                        <td>{medication.dosage}</td>
                                        <td>
                                            <button onClick = { () => this.updateMedication(medication.id)}className = " btn btn-info">Update</button>
                                            <button onClick = { () => this.deleteMedication(medication.id)} className = " btn btn-danger" style={{marginLeft: "15px"}}>Delete</button>
                                        </td>
                                    </tr>
                                )
                        }
                        </tbody>
                    </table>
                </div>

            </div>
        );
    }
}

export default DoctorPageComponent;