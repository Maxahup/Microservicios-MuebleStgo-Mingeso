import './App.css';
import { Routes, Route } from 'react-router-dom';
import { Container } from 'react-bootstrap';
import Layout from './Layout';
import Index from './pages/Index';
import Empleados from './pages/Empleados';
import CargarJustificativo from './pages/CargarJustificativos';
import CargarAutorizacion from './pages/CargarAutorizaciones';
import UploadClockData from './pages/UploadClockData';

function App() {
  return (
    <Layout>
      <Container>
        <Routes>
          <Route path='/'element={<Index/>} exact/>
          <Route path='/empleados' element={<Empleados/>} exact/>
          <Route path='/upload' element={<UploadClockData/>} exact/>
          <Route path='/uploadJustificativo' element={<CargarJustificativo/>} exact/>
          <Route path='/uploadAutorizacion' element={<CargarAutorizacion/>} exact/>

        </Routes>
      </Container>
    </Layout>
  );
}

export default App;
