package mendes.sutil.dyego.awspresignedpost.domain.conditions;

import java.util.Objects;

import static mendes.sutil.dyego.awspresignedpost.domain.conditions.ConditionField.META;

public class MetaCondition extends MatchCondition {

    private final String metaName;

    public MetaCondition(Operator operator, String metaName, String value) {
        super(META, operator, value);
        Objects.requireNonNull(operator);
        Objects.requireNonNull(metaName);
        Objects.requireNonNull(value);
        this.metaName = metaName;
    }

    @Override
    public String[] asAwsPolicyCondition() {
        return new String[]{
                getConditionOperator().awsOperatorValue,
                super.getConditionField().valueForAwsPolicy.concat(metaName),
                getValue()
        };
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof MetaCondition &&
                ((MetaCondition) obj).getConditionField() == this.conditionField &&
                ((MetaCondition) obj).getConditionOperator() == this.getConditionOperator() &&
                Objects.equals(((MetaCondition) obj).metaName, this.metaName);
    }

    public String getMetaName() {
        return metaName;
    }
}
