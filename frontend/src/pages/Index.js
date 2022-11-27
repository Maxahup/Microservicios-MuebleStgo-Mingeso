import { Col, Container, Row} from "react-bootstrap";
import logo from '../logo.svg';

const Index = () => {
    return (
        <Container style={{display: 'flex', justifyContent: 'center', marginTop: '70px'}}>
            <Row>
                <Col sm="12">
                    <h1>Bienvenido a la página de administración de MuebleStgo</h1>
                </Col>
                <Col sm= "12">
                    <img src = {logo}className="logo" alt="logo"/>
                </Col>
            </Row>
        </Container>


    );
}

export default Index; 