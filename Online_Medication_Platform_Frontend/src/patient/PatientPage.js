import React, { Component } from 'react';
import IntakeService from '../intake/IntakeService';

class PatientPage extends Component {
    constructor(props) {
        super(props)
        this.state = {
            intakes: [],
            start_date: '',
            end_date: '',
            medication_id: '',
            patientID: localStorage.getItem('patientID')
        }

    }

    componentDidMount(){
        console.log(this.state.patientID);
        IntakeService.getIntakes(this.state.patientID).then((res) => {
            this.setState({ intakes: res.data})
        });

        console.log(this.state.intakes);

        this.setState({patientID: localStorage.getItem('patientID')})
    }

    render() {
        return (
            <div>
                <div className="container">
                    <h3>Patient Page - show intakes list</h3>
                    {this.state.message && <div class="alert alert-success">{this.state.message}</div>}
                
                <div className="container">
                    
                    <table className="table">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Start-date</th>
                                <th>End-date</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.intakes.map(
                                    intake =>
                                        <tr key={intake.id}>
                                        	<td>{intake.id}</td>
                                            <td>{intake.start_date}</td>
                                            <td>{intake.end_date}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                  
                </div>
            </div>
                
            </div>
        );
    }
}

export default PatientPage;