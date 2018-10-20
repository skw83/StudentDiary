package pl.school.parent.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.school.parent.dto.ParentDto;
import pl.school.parent.entity.Parent;
import pl.school.parent.repository.ParentRepository;
import pl.school.parent.service.ParentService;

@Service
public class ParentServiceImpl implements ParentService {
	
	private final ParentRepository parentRepo;
	
	@Autowired
	public ParentServiceImpl(ParentRepository parentRepo) {
		this.parentRepo = parentRepo;
	}

	@Override
	public ParentDto save(ParentDto dto) {
		return parentRepo.save(toParentEntity(dto)).toDto();
	}

	@Override
	public ParentDto update(ParentDto dto) {
		return parentRepo.save(toParentEntity(dto)).toDto();
	}

	@Override
	public ParentDto find(Long id) {
		return parentRepo.findOne(id).toDto();
	}

	@Override
	public Boolean remove(Long id) {
		parentRepo.delete(id);
		if(Objects.nonNull(parentRepo.findOne(id))) {
			return true;
		}else
		return null;
	}

	@Override
	public Collection<ParentDto> getAll() {
		return toParentDtoList(parentRepo.findAll());
	}
	
	private Collection<ParentDto> toParentDtoList(List<Parent> parents) {
		return 
			parents.stream().filter(Objects::nonNull).map(Parent::toDto).collect(Collectors.toList());
	}


	private Parent toParentEntity(ParentDto dto) {
		
		Parent parent = new Parent();
		
		parent.setId(dto.getId());
		parent.setName(dto.getName());
		parent.setSurname(dto.getSurname());
		parent.setEmail(dto.getEmail());
		return parent;
	}

}
