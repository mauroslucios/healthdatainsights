package br.com.healthdatainsights.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.healthdatainsights.app.dto.MedicoDTO;
import br.com.healthdatainsights.app.entity.Medico;
import br.com.healthdatainsights.app.repository.MedicoRepository;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    /*
     * Injeção de dependência sem a necessidade de @Autowired 
     * 
     */
    
    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<MedicoDTO> findAll() {
        try {
            List<Medico> list = medicoRepository.findAll();
            return MedicoDTO.converter(list);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar médicos", e);
        }
    }
    
    public Medico insertMedico(Medico medico) {
		return medicoRepository.save(medico);
	}

    public MedicoDTO findById(Long id) {
        Medico medico = medicoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Médico não encontrado com ID: " + id));
        return new MedicoDTO(medico);
    }

}
