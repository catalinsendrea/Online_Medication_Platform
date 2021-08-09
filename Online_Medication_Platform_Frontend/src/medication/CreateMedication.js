import React, { Component } from 'react';
import MedicationService from '../medication/MedicationService';

class CreateMedication extends Component {
    constructor(props){
        super(props)

        this.state = {
            id:'',
            name:'',
            list_of_side_effects:'',
            dosage:'', 
        }

        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeDosageHandler = this.changeDosageHandler.bind(this);
        this.changeEffectsHandler = this.changeEffectsHandler.bind(this);
        this.saveMedicationButton = this.saveMedicationButton.bind(this);
        this.cancelButton = this.cancelButton.bind(this);
    }

    changeIdHandler = (event) => {
        this.setState({id: event.target.value});
    }

    changeNameHandler = (event) => {
        this.setState({name: event.target.value});
    }

    changeDosageHandler = (event) => {
        this.setState({dosage: event.target.value});
    }

    changeEffectsHandler = (event) => {
        this.setState({list_of_side_effects: event.target.value});
    }
    
    cancelButton(){
        this.props.history.push('/doctor');
    }

    saveMedicationButton = (x) => {
        x.preventDefault();
        let medication = {id: this.state.id, name: this.state.name, list_of_side_effects: this.state.list_of_side_effects, dosage: this.state.dosage};
        console.log('medication  => ' +JSON.stringify(medication));

        MedicationService.createMedication(medication).then(res => {
            this.props.history.push('/doctor');
        });
    }
    
    render() {
        return (
            <div>
                <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3"> 
                                <h1 className="text-center">Insert Medication</h1>
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
                                            <label>Side effects: </label>
                                            <input placeholder="Side effects" name ="side_effects" className="form-control"
                                                value={this.state.list_of_side_effects} onChange={this.changeEffectsHandler}/>
                                        </div>

                                        <div className ="form-group">
                                            <label>Dosage: </label>
                                            <input placeholder="(mg)" name ="dosage" className="form-control"
                                                value={this.state.dosage} onChange={this.changeDosageHandler}/>
                                        </div>
                                
                                        <button className="btn btn-success" onClick={this.saveMedicationButton}>Save</button>
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

export default CreateMedication;