package votacion;

import java.util.ArrayList;
import java.util.List;


public class Subject {

    private List<JFrameObserver> observadores = new ArrayList<JFrameObserver>();
	private int mas;
        private int f21;
        private int cc;
        
        

	public int getMAS() {
		return mas;
	}
        public int getF21() {
		return f21;
	}
        public int getCC() {
		return cc;
	}
        

	public void setVotacion(int mas,int f21,int cc) {
		this.mas = mas;
                this.f21 = f21;
                this.cc = cc;
                
		notificarTodosObservadores();
	}

	public void agregar(JFrameObserver observador) {
		observadores.add(observador);
	}

	public void notificarTodosObservadores() {
		observadores.forEach(x -> x.actualizar(this.mas,this.f21,this.cc));
                
	}

}
