# Copilot Instructions

## Project Context

This project follows a structured development approach with comprehensive documentation in the `./docs` directory.

**You MUST always consult and reference these documentation files before making any decisions or suggestions:**

- **TRD (Technical Requirements Document)**: Technical specifications, architecture decisions, and implementation requirements
- **FRD (Functional Requirements Document)**: Functional specifications, business rules, and user requirements
- **AGENTS.MD**: Custom agent definitions and their specific roles in the project
- **Other documentation**: Any additional context files in `./docs`

---

## Core Principles

### 1. Documentation-First Approach
- **ALWAYS** read and understand relevant documentation before suggesting code changes
- When uncertain about requirements, **reference the docs explicitly**
- If documentation conflicts with code, **flag the inconsistency** and ask for clarification
- Keep documentation and code in sync

### 2. Agent-Aware Development
- Recognize when a task should be handled by a specific agent (defined in `AGENTS.MD`)
- Suggest using specialized agents for:
    - Code reviews (use code-review-specialist agent)
    - Unit testing (use unit-testing-specialist agent)
    - Other specialized tasks as defined in the agents documentation

### 3. Quality Standards
- Follow senior-level coding practices
- Write clean, maintainable, and well-documented code
- Ensure comprehensive test coverage
- Apply SOLID principles and design patterns appropriately

---

## Workflow Guidelines

### Before Starting Any Task

1. **Read the documentation**:
   ```
   Check ./docs/TRD.md for technical context
   Check ./docs/FRD.md for business requirements
   Check ./docs/AGENTS.MD for specialized agent roles
   ```

2. **Understand the requirement**:
    - What is the business goal?
    - What are the technical constraints?
    - Are there existing patterns to follow?

3. **Plan the approach**:
    - Identify affected components
    - Consider architectural impact
    - Determine if specialized agents are needed

### During Development

- **Reference documentation** when making architectural decisions
- **Follow established patterns** documented in TRD
- **Respect business rules** defined in FRD
- **Write tests first** or alongside implementation
- **Keep code and docs aligned**

### Code Review & Testing

- For **code reviews**: Recommend using the `code-review-specialist` agent
- For **unit tests**: Recommend using the `unit-testing-specialist` agent
- Ensure all changes comply with documented standards

---

## Documentation References

### When to Check TRD
- Architecture and design decisions
- Technology stack and framework choices
- Integration patterns and APIs
- Performance and scalability requirements
- Security and infrastructure concerns

### When to Check FRD
- Business logic and rules
- User workflows and use cases
- Feature requirements and acceptance criteria
- Data models and business entities
- Validation rules and constraints

### When to Check AGENTS.MD
- Understanding available specialized agents
- Determining which agent to use for specific tasks
- Understanding agent capabilities and limitations
- Following agent-specific guidelines

---

## Code Standards

### General Principles
- Write self-documenting code with clear naming
- Follow language-specific conventions and idioms
- Apply DRY (Don't Repeat Yourself) appropriately
- Keep functions/methods focused and small
- Use meaningful variable and function names

### Testing Requirements
- Write unit tests for all business logic
- Ensure tests are fast, isolated, and deterministic
- Follow AAA (Arrange-Act-Assert) pattern
- Test happy paths, edge cases, and error scenarios
- Maintain high test coverage for critical paths

### Documentation Requirements
- Document complex business logic
- Add comments for non-obvious decisions
- Keep README and docs up to date
- Document public APIs and interfaces

---

## Project-Specific Context

### Architecture Overview
> Reference `./docs/TRD.md` for detailed technical architecture.

Key architectural decisions and patterns are documented in the TRD. Always consult it for:
- Layer responsibilities and boundaries
- Dependency management
- Data flow patterns
- External integrations

### Business Domain
> Reference `./docs/FRD.md` for business context and requirements.

The FRD contains critical business knowledge including:
- Domain terminology and concepts
- Business rules and validations
- User workflows and scenarios
- Feature specifications

### Custom Agents
> Reference `./docs/AGENTS.MD` for specialized agent capabilities.

Custom agents are available for specific tasks:
- **code-review-specialist**: Structured code reviews with educational feedback
- **unit-testing-specialist**: Professional-grade test creation and review
- Additional agents as defined in the documentation

---

## Communication Style

### When Providing Suggestions
- Be **clear and specific**
- Explain **why**, not just **what**
- Reference **documentation** when applicable
- Provide **concrete examples**
- Offer **alternatives** when appropriate

### When Asking Questions
- Be **specific** about what's unclear
- Reference the **relevant documentation**
- Explain **why** the clarification is needed
- Suggest **possible interpretations**

### When Flagging Issues
- Clearly state the **problem**
- Explain the **impact**
- Reference **violated standards or requirements**
- Suggest **solutions**

---

## Special Scenarios

### When Documentation is Missing
If required information is not in the docs:
1. Flag the missing documentation explicitly
2. Ask the user for clarification
3. Suggest documenting the decision
4. Proceed cautiously with reasonable assumptions (state them clearly)

### When Documentation Conflicts with Code
If you find inconsistencies:
1. **Point out the conflict** clearly
2. **Ask which is correct**: docs or code
3. **Suggest updating** the incorrect one
4. **Don't assume** — always clarify

### When Requirements are Ambiguous
If specifications are unclear:
1. **State what's ambiguous**
2. **Reference the relevant doc section**
3. **Propose interpretations**
4. **Wait for clarification** before proceeding

### When Suggesting Refactoring
Before suggesting major changes:
1. **Check if it aligns** with documented architecture
2. **Assess impact** on existing components
3. **Consider technical debt** vs. immediate value
4. **Discuss trade-offs** explicitly

---

## Task-Specific Guidelines

### Feature Implementation
1. Read FRD for requirements
2. Read TRD for technical approach
3. Identify affected components
4. Plan implementation with tests
5. Implement following documented patterns
6. Use appropriate agent for review

### Bug Fixes
1. Understand the expected behavior (FRD)
2. Identify the root cause
3. Check if it reveals a documentation gap
4. Fix with tests to prevent regression
5. Update docs if behavior was unclear

### Refactoring
1. Ensure it aligns with TRD architecture
2. Maintain behavior (verify with tests)
3. Improve code quality incrementally
4. Use code-review-specialist for validation
5. Update documentation if patterns change

### Testing
1. Use unit-testing-specialist agent
2. Follow testing standards in TRD
3. Cover critical paths comprehensively
4. Ensure tests are fast and isolated
5. Document complex test scenarios

---

## Prohibited Actions

**DO NOT**:
- Make architectural decisions without consulting TRD
- Implement features without checking FRD
- Ignore documented patterns and standards
- Skip writing tests for business logic
- Leave documentation out of sync with code
- Assume requirements without verification

---

## Quick Reference Checklist

Before suggesting code changes, ask yourself:

- [ ] Have I read the relevant documentation in `./docs`?
- [ ] Do I understand the business requirement (FRD)?
- [ ] Do I understand the technical approach (TRD)?
- [ ] Should this task use a specialized agent (AGENTS.MD)?
- [ ] Does my suggestion align with documented patterns?
- [ ] Have I considered testing requirements?
- [ ] Will this change require documentation updates?
- [ ] Have I explained my reasoning clearly?

---

## Examples

### Good Interaction

**User**: "I need to add validation to the user registration endpoint"

**Copilot**:
```
Let me check the documentation first:

From ./docs/FRD.md, I can see the user registration requirements include:
- Email format validation
- Password strength requirements
- Unique username check

From ./docs/TRD.md, the validation layer should be implemented in:
- [specific layer/component based on your architecture]

I'll suggest an implementation following these documented patterns.
Would you like me to also prepare tests using the unit-testing-specialist agent?
```

### Bad Interaction

**User**: "I need to add validation to the user registration endpoint"

**Copilot**:
```
Here's a validation function: [provides code without checking docs]
```
❌ *Didn't check FRD for business rules*
❌ *Didn't check TRD for architectural patterns*
❌ *Didn't consider testing*

---

## Getting Started

When you first start working on this project:

1. **Read all documentation** in `./docs`:
    - Start with FRD to understand the business domain
    - Then read TRD for technical context
    - Review AGENTS.MD to understand available tools

2. **Understand the codebase structure**:
    - How does it align with TRD architecture?
    - Where are the main components?
    - What are the testing patterns?

3. **Identify your task context**:
    - What type of work are you doing?
    - Which documentation is most relevant?
    - Should you use a specialized agent?

4. **Ask clarifying questions** if anything is unclear

---

## Continuous Improvement

- **Suggest documentation updates** when you find gaps
- **Flag outdated documentation** when you find inconsistencies
- **Recommend new patterns** when you see opportunities
- **Help keep docs and code in sync**

---

**Remember**: Documentation is the source of truth. When in doubt, read the docs first, then ask questions.