import React, { useState } from 'react';
import styles from './index.css';
import imageLogo from "../../../images/logo.png";
import {
    Collapse,
    Navbar,
    NavbarToggler,
    NavbarBrand,
    Nav,
    NavItem,
    NavLink,
    UncontrolledDropdown,
    DropdownToggle,
    DropdownMenu,
    DropdownItem,
    NavbarText
} from 'reactstrap';

const Headers = (props) => {
    const [isOpen, setIsOpen] = useState(false);

    const toggle = () => setIsOpen(!isOpen);

    return (
        <div>
            <Navbar className="navBar"  dark expand="md">
                <NavbarBrand  href="#"><img src={imageLogo}/></NavbarBrand>
                <NavbarToggler onClick={toggle} />
                <Collapse isOpen={isOpen} navbar  >
                    <Nav className="mr-auto " navbar className="nav">
                        <NavItem>
                            <NavLink className="active" href="#">Produtos</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink href="#">Orçamentos</NavLink>
                        </NavItem>
                        <NavItem>
                            <NavLink href="#">Sobre</NavLink>
                        </NavItem>
                    </Nav>
                </Collapse>
            </Navbar>
        </div>
    );
}


export default Headers;
