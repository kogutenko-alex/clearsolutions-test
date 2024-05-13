package com.kogutenko.clearsolutions.user.service.impl;

import com.kogutenko.clearsolutions.common.exception.business.NotFoundException;
import com.kogutenko.clearsolutions.user.repository.UserRepository;
import com.kogutenko.clearsolutions.user.repository.entity.User;
import com.kogutenko.clearsolutions.user.service.UserService;
import com.kogutenko.clearsolutions.user.service.filter.UserFilter;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.kogutenko.clearsolutions.common.util.Constants.User.USER_NOT_FOUND;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static lombok.AccessLevel.PRIVATE;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    @Override
    public Page<User> findAll(UserFilter filter, Pageable pageable) {
        Specification<User> filterBy = filterBy(filter);
        return userRepository.findAll(filterBy, pageable);
    }

    @Override
    public User find(UUID userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> new NotFoundException(USER_NOT_FOUND));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }


    private Specification<User> filterBy(UserFilter filter) {
        return (r, rq, cb) -> {
            Predicate afterDatePredicate = nonNull(filter.getAfterDate()) && isNull(filter.getBeforeDate()) ?
                    cb.greaterThanOrEqualTo(r.get("birthDate"), filter.getAfterDate()) :
                    cb.conjunction();

            Predicate dateRangePredicate = nonNull(filter.getAfterDate()) && nonNull(filter.getBeforeDate()) ?
                    cb.between(
                            r.get("birthDate"),
                            filter.getAfterDate(),
                            filter.getBeforeDate()
                    ) : cb.conjunction();

            Predicate beforeDatePredicate = isNull(filter.getAfterDate()) && nonNull(filter.getBeforeDate()) ?
                    cb.lessThanOrEqualTo(r.get("birthDate"), filter.getBeforeDate()) :
                    cb.conjunction();

            return cb.and(afterDatePredicate, dateRangePredicate, beforeDatePredicate);
        };
    }
}
