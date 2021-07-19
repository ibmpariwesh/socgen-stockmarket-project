package socgen.iiht.relationshipservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import socgen.iiht.relationshipservice.model.CompanyToBoardMember;

@Repository
public interface CompanyToBoardMemberRepo extends JpaRepository<CompanyToBoardMember,Integer> {
    public void deleteAllByCompanyId(int id);
}
