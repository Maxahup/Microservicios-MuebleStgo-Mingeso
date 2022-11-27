import { useState , useEffect } from 'react';
import axios from 'axios';
import { Container, Row, Col, Table, Button } from 'react-bootstrap';


const Empleados = () => {
    const [empleados, setEmpleados] = useState([]);

    const getEmpleados = async () => {
        try {
            let url = 'http://localhost:8080/planilla/getAll';
            let response = await axios.get(url);
            if (response.status === 200) {
                setEmpleados(response.data);
            }
        } catch (error) {
            console.log(error.message)
        }
    };

    const createForm = async () => {
        let url2 = 'http://localhost:8080/planilla/generar-planilla';
        axios.post(url2);
    }

    useEffect(() => {
        getEmpleados();
    }, [] );

    return (
        <Container style= {{marginTop: '70px'}}>
            <Row>
                <Col><h1>Planilla de Pagos</h1></Col>
            </Row>
            {/* <Row>
                <Col>
                    <Button variant="success">Generar planilla</Button>
                </Col>
            </Row> */}
            <Row className="mt-2">
                <Col lg="3" sm="4">
                    {/* <Button href="/employees/new">+ Nuevo Empleado</Button> */}
                    <Button variant="success" onClick={createForm}>Generar Planilla</Button>
                </Col>
                {/* <Col lg="9" sm="8">
                    <Alert variant="danger" style={{width: "100%", height:"40px"}} show={showAlert} >
                        <p style={{marginTop: "-8px"}}>{messageAlert}</p>
                    </Alert>
                </Col> */}
            </Row>
            <Row>
                <Col cols="12">
                    <Table striped className="mt-4">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Rut</th>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>Años de Servicio</th>
                                <th>Categoría</th>
                                <th>Sueldo Fijo</th>
                                <th>Bono Años de Servicio</th>
                                <th>Bono horas extras</th>
                                <th>Descuentos</th>
                                <th>Sueldo Bruto</th>
                                <th>Cotización Previsional</th>
                                <th>Cotización Salud</th>
                                <th>Sueldo Líquido</th>
                            </tr>
                        </thead>
                        <tbody>
                            {empleados.map((empleado) => (
                                <tr key={empleado.id}>
                                    <td>{empleado.id}</td>
                                    <td>{empleado.rut}</td>
                                    <td>{empleado.nombre}</td>
                                    <td>{empleado.apellidos}</td>
                                    <td>{empleado.anno_Servicios}</td>
                                    <td>{empleado.categoria}</td>
                                    <td>{empleado.sueldo_fijo}</td>
                                    <td>{empleado.bonificacion_annos_servicios}</td>
                                    <td>{empleado.bonificacion_horas_extras}</td>
                                    <td>{empleado.descuentos}</td>
                                    <td>{empleado.sueldo_bruto}</td>
                                    <td>{empleado.cotizacion_previsonal}</td>
                                    <td>{empleado.cotizacion_salud}</td>
                                    <td>{empleado.sueldo_liquido}</td>
                                </tr>
                            ))}
                        </tbody>
                    </Table>
                </Col>
            </Row>
            
        </Container>

    );

};


export default Empleados;