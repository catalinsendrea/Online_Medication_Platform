import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import NavigationBar from './navigation-bar'
import Home from './home/home';
import styles from './styles/project-style.css';
import DoctorPageComponent from './doctor/DoctorPageComponent';
import CreateCaregiver from './caregiver/CreateCaregiver';
import CreateMedication from './medication/CreateMedication';
import CreatePatient from './patient/CreatePatient';
import UpdateCaregiver from './caregiver/UpdateCaregiver';
import UpdateMedication from './medication/UpdateMedication';
import UpdatePatient from './patient/UpdatePatient';
import CreateIntake from './intake/CreateIntake';
import LoginPage from './login/LoginPage';
import PatientPage from './patient/PatientPage';

function App() {
  return (
    <div className={styles.back}>
    <Router>
        <div>
            <NavigationBar />
            <Switch>
                <Route path='/' exact component = {Home}></Route>
                <Route path='/login' component = {LoginPage} ></Route>
                
                    <div className="container">
                         <Route path='/doctor' component = {DoctorPageComponent} ></Route>
                         <Route path='/patient' component = {PatientPage} ></Route>

                         <Route path='/add-caregiver' component = {CreateCaregiver} ></Route>
                         <Route path='/update-caregiver/:id' component = {UpdateCaregiver} ></Route>

                         <Route path='/add-medication' component = {CreateMedication} ></Route>
                         <Route path='/update-medication/:id' component = {UpdateMedication} ></Route>

                         <Route path='/add-patient' component = {CreatePatient} ></Route>
                         <Route path='/update-patient/:id' component = {UpdatePatient} ></Route>

                         <Route path='/add-intake' component = {CreateIntake} ></Route>

                    </div>
            </Switch>
        </div>
    </Router>
    </div>
)
};


export default App;
