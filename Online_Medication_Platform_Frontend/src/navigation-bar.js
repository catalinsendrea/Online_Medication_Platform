import React from 'react'
import logo from './images/icon.png';

import {
    Nav,
    Navbar,
    NavbarBrand,
} from 'reactstrap';

const NavigationBar = () => (
    <div>
        <Navbar color="dark" light expand="md">
            <NavbarBrand href="/">
             
                <img src={logo} width={"50"}
                     height={"35"} alt="lol"/>
            </NavbarBrand>

            <Nav className="mr-auto" navbar>

                <a href="/login" class="btn btn-success pull-right">LOGIN</a>
                <a href="/" class="btn btn-danger" style={{marginLeft: "1250px"}} >LOGOUT</a>

            </Nav>

        </Navbar>
    </div>
);

export default NavigationBar
