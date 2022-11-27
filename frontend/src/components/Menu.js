import {Nav, Navbar, Container } from 'react-bootstrap';

const Menu = () => {
    return (
        <Navbar bg="dark" variant="dark" fixed="top">
            <Container>
                <Navbar.Brand href="/">MuebleStgo</Navbar.Brand>
                <Navbar.Toggle aria-controls='responsive-navbar'/>
                <Navbar.Collapse id="responsive-navbar">
                    <Nav className='me-auto'>
                        <Nav.Link href="/">Inicio</Nav.Link>
                        <Nav.Link href="/upload">Subir Marcas de Reloj</Nav.Link>
                        <Nav.Link href="/uploadJustificativo">Subir Justificativos</Nav.Link>
                        <Nav.Link href="/uploadAutorizacion">Subir Autorizaciones</Nav.Link>
                        <Nav.Link href="/empleados">Ver Planilla Pagos</Nav.Link>

                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>

    );
};

export default Menu;