package com.example.planilla.Service;

import com.example.planilla.Entity.Planilla;
import com.example.planilla.Model.Marca;
import com.example.planilla.Model.Personal;
import com.example.planilla.Repository.PlanillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PlanillaService {

    @Autowired
    PlanillaRepository planillaRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Planilla> getAll(){
        List<Planilla> planillaFull = planillaRepository.findAll();
        return planillaFull;
    }

    public Planilla getPlanillaById(int id){
        Planilla buscada = planillaRepository.findById(id).orElse(null);
        return buscada;
    }
    public void save(Planilla planilla){
        planillaRepository.save((planilla));
    }


    public void generarReporte(List<Personal> listaPersonal, List<Marca> listaMarcas){
        System.out.println(listaPersonal);
        int cantidadEmpleados = listaPersonal.size();
        int cantidadMarcas = listaMarcas.size();
        for (int i=0; i<cantidadEmpleados; i++){
            String rutActual = listaPersonal.get(i).getRut();
            String nombreActual = listaPersonal.get(i).getNombre();
            String apellidosActual = listaPersonal.get(i).getApellidos();
            char categoria = listaPersonal.get(i).getCategoria();
            int annos_servicioActual = listaPersonal.get(i).getAnno_Servicios();
            int sueldo_fijoActual = listaPersonal.get(i).getSueldo_fijo();
            //char categoriaActual = listaPersonal.get(i).getCategoria();
            double dscto10min=0;
            double dscto25min=0;
            double dscto45min=0;
            double dsctoAusencia=0;
            double sueldoLiquido=0;
            int bonoHorasExtras=0;
            double bono_annosServicio = 0;
            if (annos_servicioActual>=5 && annos_servicioActual <10){
                bono_annosServicio=sueldo_fijoActual*(0.05);
            }
            if (annos_servicioActual>=10 && annos_servicioActual <15){
                bono_annosServicio=sueldo_fijoActual*(0.08);
            }
            if (annos_servicioActual>=15 && annos_servicioActual <20){
                bono_annosServicio=sueldo_fijoActual*(0.11);
            }
            if (annos_servicioActual>=20 && annos_servicioActual <25){
                bono_annosServicio=sueldo_fijoActual*(0.14);
            }
            if (annos_servicioActual>=25){
                bono_annosServicio=sueldo_fijoActual*(0.17);
            }
            //ciclo para establecer descuentos
            for (int j=0; j<cantidadMarcas; j++){
                String rutMarca = listaMarcas.get(j).getRut();
                if (rutActual.equals(rutMarca)){
                    dscto10min = sueldo_fijoActual*(0.01)*listaMarcas.get(j).getMin_10();
                    dscto25min = sueldo_fijoActual*(0.03)*listaMarcas.get(j).getMin_25();
                    dscto45min = sueldo_fijoActual*(0.06)*listaMarcas.get(j).getMin_45();
                    dsctoAusencia = sueldo_fijoActual*(0.15)*listaMarcas.get(j).getAusencia();
                }
            }
            double sueldo_bruto=sueldo_fijoActual+bono_annosServicio+bonoHorasExtras;
            double dsctoPrevisional = sueldo_bruto*0.1;
            double dsctoSalud = sueldo_bruto*0.08;
            double dsctoTotal = dscto10min+dscto25min+dscto45min+dsctoAusencia+dsctoPrevisional+dsctoSalud;
            sueldoLiquido = sueldo_bruto-dsctoTotal;
            System.out.println(dsctoTotal);

            Planilla nuevoRegPlanilla = new Planilla(rutActual,nombreActual,apellidosActual,annos_servicioActual,categoria, sueldo_fijoActual,bono_annosServicio,bonoHorasExtras, dsctoTotal,sueldo_bruto,dsctoPrevisional,dsctoSalud,sueldoLiquido);
            save(nuevoRegPlanilla);

        }



    }




}
