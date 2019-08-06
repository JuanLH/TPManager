/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes.amortizado;

/**
 *
 * @author Juan
 */
public class AmortizaList {
    int cuota;
    String fecha_pago;
    Double interes_periodo,abono_capital,valor_cuota,saldo_capital;

    public int getCuota() {
        return cuota;
    }

    public void setCuota(int cuota) {
        this.cuota = cuota;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public Double getInteres_periodo() {
        return interes_periodo;
    }

    public void setInteres_periodo(Double interes_periodo) {
        this.interes_periodo = interes_periodo;
    }

    public Double getAbono_capital() {
        return abono_capital;
    }

    public void setAbono_capital(Double abono_capital) {
        this.abono_capital = abono_capital;
    }

    public Double getValor_cuota() {
        return valor_cuota;
    }

    public void setValor_cuota(Double valor_cuota) {
        this.valor_cuota = valor_cuota;
    }

    public Double getSaldo_capital() {
        return saldo_capital;
    }

    public void setSaldo_capital(Double saldo_capital) {
        this.saldo_capital = saldo_capital;
    }
    
    
}
